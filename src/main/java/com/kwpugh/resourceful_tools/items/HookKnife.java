package com.kwpugh.resourceful_tools.items;

import java.util.List;

import com.kwpugh.resourceful_tools.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class HookKnife extends Item
{
	public HookKnife(Settings settings)
	{
		super(settings);
	}
	   
	@Override
	public ActionResult useOnBlock(ItemUsageContext context)
	{
		World world = context.getWorld();
		PlayerEntity player = context.getPlayer();
		BlockPos pos = context.getBlockPos();
		BlockState state = world.getBlockState(pos);
		Block block = state.getBlock();
		ItemStack stack = context.getStack();
	      
		if(block == Blocks.WHITE_WOOL ||
	    		 block == Blocks.BLACK_WOOL ||
	    		 block == Blocks.BLUE_WOOL ||
	    		 block == Blocks.BROWN_WOOL ||
	    		 block == Blocks.CYAN_WOOL ||
	    		 block == Blocks.GRAY_WOOL ||
	    		 block == Blocks.GREEN_WOOL ||
	    		 block == Blocks.LIGHT_BLUE_WOOL ||
	    		 block == Blocks.LIGHT_GRAY_WOOL ||
	    		 block == Blocks.LIME_WOOL ||
	    		 block == Blocks.MAGENTA_WOOL ||
	    		 block == Blocks.ORANGE_WOOL ||
	    		 block == Blocks.PINK_WOOL ||
	    		 block == Blocks.PURPLE_WOOL ||
	    		 block == Blocks.RED_WOOL ||
	    		 block == Blocks.YELLOW_WOOL
	    		 )
	    {
			world.removeBlock(pos, false);
			world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.STRING, 4))); 
			stack.damage(1, player, (p_220038_0_) -> {
				p_220038_0_.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
		         });
	    }
	     
		return super.useOnBlock(context);
	}
	
	@Override
	public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) 
	{
		World world = user.world;
		Vec3d pos = entity.getPos();
	
		if(entity instanceof SheepEntity)
		{			
			world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.STRING, 1))); 
			stack.damage(1, user, (callback) -> {
				callback.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
				});	
		}
	
		return ActionResult.PASS;
	}
	
	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
	{
		tooltip.add(new TranslatableText("item.resourceful_tools.hook_knife.line1").formatted(Formatting.YELLOW));
		tooltip.add(new TranslatableText("item.resourceful_tools.hook_knife.line2").formatted(Formatting.YELLOW));
	} 
}




