/*
    Multipass, Nukkit permissions plugin
    Copyright (C) 2016  fromgate, nukkit.ru

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ru.nukkit.multipass.command.perm;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import ru.nukkit.multipass.MultipassPlugin;
import ru.nukkit.multipass.command.Cmd;
import ru.nukkit.multipass.command.CmdDefine;
import ru.nukkit.multipass.permissions.Groups;
import ru.nukkit.multipass.permissions.Users;
import ru.nukkit.multipass.util.Message;

@CmdDefine(command = "perm", alias = "permission", allowConsole = true, subCommands = "reload", permission = "multipass.admin", description = Message.CMD_PERM_RELOAD)
public class PermReload extends Cmd {
    @Override
    public boolean execute(CommandSender sender, Player player, String[] args) {
        MultipassPlugin.getCfg().load();
        Groups.loadGroups();
        Users.reloadUsers();
        return Message.PERM_RELOADED.print(sender);
    }
}
