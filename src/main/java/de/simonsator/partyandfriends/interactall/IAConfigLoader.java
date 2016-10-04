package de.simonsator.partyandfriends.interactall;

import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

/**
 * @author Simonsator
 * @version 1.0.0 18.09.16
 */
public class IAConfigLoader extends ConfigurationCreator {
	protected IAConfigLoader(File file) throws IOException {
		super(file);
		readFile();
		loadDefaultValues();
		saveFile();
		process(configuration);
	}

	private void loadDefaultValues() {
		set("AcceptAll.Names", "acceptall", "aa");
		set("AcceptAll.Priority", 3);
		set("AcceptAll.LargeOutput.Use", false);
		set("AcceptAll.LargeOutput.AcceptCommandName", "accept");
		set("DenyAll.LargeOutput.Use", false);
		set("DenyAll.LargeOutput.DenyAllCommandName", "deny");
		set("DenyAll.Names", "denyall", "da");
		set("DenyAll.Priority", 4);
		set("Messages.AcceptAll.Help", "&8/&5friend acceptall &8- &7Accept all friend requests");
		set("Messages.AcceptAll.AcceptedAll", " &7You accepted all requests");
		set("Messages.NoFriendRequests", " &7You don't have any friend requests");
		set("Messages.DenyAll.Help", "&8/&5friend denyall &8- &7Deny all friend requests");
		set("Messages.DenyAll.DeniedAll", " &7You denied all requests");
	}

	@Override
	public void reloadConfiguration() throws IOException {
		configuration = (new IAConfigLoader(FILE)).getCreatedConfiguration();
	}
}

