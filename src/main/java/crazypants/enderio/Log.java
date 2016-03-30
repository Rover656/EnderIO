package crazypants.enderio;

import net.minecraft.launchwrapper.Launch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class Log {

  private static final boolean inDev = (Boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");

  public static final Logger LOGGER = LogManager.getLogger(EnderIO.MODID);

  public static void warn(String msg) {
    LOGGER.warn(msg);
  }

  public static void error(String msg) {
    LOGGER.error(msg);
  }

  public static void info(String msg) {
    LOGGER.info(msg);
  }

  public static void debug(String msg) {
    if (inDev) {
      LOGGER.info("INDEV: " + msg);
    } else {
      LOGGER.debug(msg);
    }
  }

  private Log() {
  }

}
