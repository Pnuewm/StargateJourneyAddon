package net.pnuewm.sgjourneyaddon.mixin;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.povstalec.sgjourney.common.data.Universe;
import org.spongepowered.asm.mixin.Mixin;
import net.povstalec.sgjourney.common.sgjourney.PointOfOrigin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import javax.annotation.Nullable;

@Mixin(PointOfOrigin.class)
public abstract class PointOfOriginMixin
{
    @Inject(method = "randomPointOfOrigin", at = @At("HEAD"), cancellable = true)
    private static void randomPointOfOriginMixin(@Nullable ServerLevel level, CallbackInfoReturnable<ResourceKey<PointOfOrigin>> cir)
    {
        cir.setReturnValue(Universe.get(level).getPointOfOrigin(level.dimension()));
    }
}
