package de.simonsator.partyandfriends.velocity.interactall;

import de.simonsator.partyandfriends.velocity.api.PAFExtension;
import de.simonsator.partyandfriends.velocity.friends.commands.Friends;
import de.simonsator.partyandfriends.velocity.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class IAMain extends PAFExtension {
	private static IAMain instance;
	private IAConfigLoader config;

	public IAMain(Path folder) {
		super(folder);
	}

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

	@Override
	public String getName() {
		return "InteractAll";
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

