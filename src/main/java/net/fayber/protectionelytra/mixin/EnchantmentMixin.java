package net.fayber.protectionelytra.mixin;

import net.fayber.protectionelytra.logic.ProtectionElytraLogic;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class EnchantmentMixin {

    @Inject(method = "canEnchant", at = @At("HEAD"), cancellable = true)
    private void allowProtectionOnElytra(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.getItem() == Items.ELYTRA) {
            Enchantment self = (Enchantment) (Object) this;
            if (ProtectionElytraLogic.canEnchantElytra(self)) {
                cir.setReturnValue(true);
            }
        }
    }
}
