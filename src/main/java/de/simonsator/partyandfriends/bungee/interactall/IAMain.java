package de.simonsator.partyandfriends.bungee.interactall;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.friends.commands.Friends;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

public class IAMain extends PAFExtension {
	private static IAMain instance;
	private IAConfigLoader config;

	static IAMain getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		try {
			config = new IAConfigLoader(new File(getConfigFolder(), "config.yml"), this);
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
		registerAsExtension();
	}


	public ConfigurationCreator getConfig() {
		return config;
	}

	@Override
	public void reload() {
		onDisable();
		onEnable();
	}
}

