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

package ru.nukkit.multipass.permissions;

import ru.nukkit.multipass.MultipassPlugin;

public class Group extends BaseNode {

    public Group(String name, Node node) {
        super(name, node);
    }

    public Group(String name) {
        this(name, MultipassPlugin.getCfg().defaultGroup.equalsIgnoreCase(name) ? 0 : MultipassPlugin.getCfg().groupPriority);
    }

    public Group(String name, int priority) {
        super(name);
        this.priority = priority;
    }

    public Group(String name, String prefix, String suffix, int priority) {
        super(name);
        this.prefix = prefix;
        this.suffix = suffix;
        this.priority = priority;
    }

    public boolean isDefault() {
        if (MultipassPlugin.getCfg().defaultGroup == null || MultipassPlugin.getCfg().defaultGroup.isEmpty())
            return false;
        return this.getName().equalsIgnoreCase(MultipassPlugin.getCfg().defaultGroup);
    }
}