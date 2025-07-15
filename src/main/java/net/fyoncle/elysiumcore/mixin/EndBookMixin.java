package net.fyoncle.elysiumcore.mixin;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.PlayerAdvancementTracker;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerAdvancementTracker.class)
public class EndBookMixin {

    @Inject(method = "grantCriterion", at = @At("TAIL"))
    private void onGrantCriterion(Advancement advancement, String criterionName, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            ServerPlayerEntity player = ((AdvancementTrackerAccessor) this).getOwner();

            Identifier id = advancement.getId();
            if (id.equals(new Identifier("minecraft", "story/enter_the_end"))) {
                ItemStack item = new ItemStack(Items.WRITTEN_BOOK);
                var nbt = item.getOrCreateNbt();
                nbt.putString("title", "The End");
                nbt.putString("author", "§kFyoncle");

                NbtList pages = new NbtList();
                String playerName = player.getName().getString();
                Text translated = Text.translatable("elysiumcore.end_book", playerName, playerName);
                pages.add(NbtString.of(Text.Serializer.toJson(translated)));

                nbt.put("pages", pages);

                nbt.putInt("CustomModelData", 1);

                if (!player.getInventory().insertStack(item)) {
                    player.dropItem(item, true);
                }
            }
        }
    }
}