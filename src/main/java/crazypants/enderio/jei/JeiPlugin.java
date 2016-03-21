package crazypants.enderio.jei;

import javax.annotation.Nonnull;

import static crazypants.util.NbtValue.MOBTYPE;
import static crazypants.util.NbtValue.SOURCE_BLOCK;
import static crazypants.util.NbtValue.SOURCE_META;

import crazypants.enderio.EnderIO;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.INbtIgnoreList;
import mezz.jei.api.JEIPlugin;
import net.minecraft.item.Item;

@JEIPlugin
public class JeiPlugin extends BlankModPlugin {

  @Override
  public void register(@Nonnull IModRegistry registry) {

    IJeiHelpers jeiHelpers = registry.getJeiHelpers();    
    IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        
    AlloyRecipeCategory.register(registry,guiHelper);
    SagMillRecipeCategory.register(registry,guiHelper);
    EnchanterRecipeCategory.register(registry,guiHelper);
    SliceAndSpliceRecipeCategory.register(registry,guiHelper);
    SoulBinderRecipeCategory.register(registry, guiHelper);
    PainterRecipeCategory.register(registry, guiHelper);
    VatRecipeCategory.register(registry, guiHelper);
           
    INbtIgnoreList nbtIgnoreList = registry.getJeiHelpers().getNbtIgnoreList();
    final Item ppplate = Item.getItemFromBlock(EnderIO.blockPaintedPressurePlate);
    if (ppplate != null) {
      nbtIgnoreList.ignoreNbtTagNames(ppplate, MOBTYPE.getKey(), SOURCE_BLOCK.getKey(), SOURCE_META.getKey());
    }
  }


}
