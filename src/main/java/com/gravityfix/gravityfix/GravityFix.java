package com.gravityfix.gravityfix;

import net.minecraftforge.fml.common.Mod;




import com.mojang.datafixers.types.templates.List;

import net.minecraft.client.renderer.FogRenderer.FogMode;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.level.entity.EntityTickList;
import net.minecraft.world.level.entity.LevelEntityGetter;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.LevelTickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;




import net.minecraftforge.event.TickEvent.ServerTickEvent;




import com.mojang.logging.LogUtils;

import org.apache.logging.log4j.util.StringMap;
import org.slf4j.Logger;


// 构建
@Mod(GravityFix.MODID)
public class GravityFix {
    public static final String MODID = "gravityfix";
    public static final Logger LOGGER = LogUtils.getLogger();

    public GravityFix() {}
    

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class EntityGravityFixer
    {
        @SubscribeEvent
        public static  void onServerTick(TickEvent.PlayerTickEvent event)
        {
            if(event == null){return;}
            
            var player = event.player;

            if (player == null){return;}

            if (player.getAttribute(ForgeMod.ENTITY_GRAVITY.get()) == null){return;}
            
            double gravity = player.getAttribute(ForgeMod.ENTITY_GRAVITY.get()).getValue();
            // 0.0031
            if (gravity < 0.024){
                player.fallDistance = 0;
            }
        }
        
    }
}