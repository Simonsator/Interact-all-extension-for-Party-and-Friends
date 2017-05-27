package de.simonsator.partyandfriends.interactall;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.friends.commands.Friends;
import net.md_5.bungee.config.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * @author Simonsator
 * @version 1.0.0 18.09.16
 */
public class IAMain extends PAFExtension {
	private IAConfigLoader config;
	private static IAMain instance;

	static IAMain getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		try {
			config = new IAConfigLoader(new File(getConfigFolder(), "config.yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (getConfig().getBoolean("AcceptAll.LargeOutput.Use"))
			Friends.getInstance().addCommand(
					new AcceptAllLargeOutput(getConfig().getStringList("AcceptAll.Names").toArray(new String[0]),
							getConfig().getInt("AcceptAll.Priority"),
							getConfig().getString("Messages.AcceptAll.Help")));
		else
			Friends.getInstance().addCommand(
					new AcceptAllSmallOutput(getConfig().getStringList("AcceptAll.Names").toArray(new String[0]),
							getConfig().getInt("AcceptAll.Priority"),
							getConfig().getString("Messages.AcceptAll.Help")));
		if (getConfig().getBoolean("DenyAll.LargeOutput.Use"))
			Friends.getInstance().addCommand(
					new DenyAllLargeOutput(getConfig().getStringList("DenyAll.Names").toArray(new String[0]),
							getConfig().getInt("DenyAll.Priority"),
							getConfig().getString("Messages.DenyAll.Help")));
		else
			Friends.getInstance().addCommand(
					new DenyAllSmallOutput(getConfig().getStringList("DenyAll.Names").toArray(new String[0]),
							getConfig().getInt("DenyAll.Priority"),
							getConfig().getString("Messages.DenyAll.Help")));
	}


	Configuration getConfig() {
		return config.getCreatedConfiguration();
	}

	@Override
	public void reload() {
		onDisable();
		onEnable();
	}
}

