package ru.nukkit.multipass.permissions;

import java.util.*;

/**
 * Created by Igor on 13.05.2016.
 */
public class Pass {


    Set<Group> groups;
    Set<Permission> permissions;
    int priority;
    String prefix;
    String suffix;


    public Pass() {
        this.permissions = new HashSet<>();
        this.groups = new HashSet<>();
        this.prefix = "";
        this.suffix = "";
        this.priority = 0;
    }

    public Pass(Pass pass) {
        groups = pass.groups;
        permissions = pass.permissions;
        priority = pass.priority;
        prefix = pass.prefix;
        suffix = pass.prefix;
    }

    public void removeGroup(String groupStr){
        Group group = Groups.getGroup(groupStr);
        if (group!=null) removeGroup(group);
    }

    public void removeGroup(Group group) {
        if (this.groups.contains(group)) this.groups.remove(group);
    }

    public void removePermission(String perm) {
        removePermission(new Permission(perm));
    }

    public void removePermission(Permission permission) {
        if (this.permissions.contains(permission))
            this.permissions.remove(permission);
    }

    public Collection<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<Permission> permissions) {
        this.permissions.clear();
        this.permissions.addAll(permissions);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setPermission(String perm, boolean positive) {
        setPermission(new Permission(perm, positive));
    }

    public void setPermission(String perm) {
        setPermission(new Permission(perm));
    }

    public void setPermission(Permission permission) {
        this.permissions.add(permission);
    }

    public List<String> getGroupList() {
        List<String> groupList = new ArrayList<>();
        groups.forEach(g -> groupList.add(g.getName()));
        return groupList;
    }

    public List<String> getPermissionList() {
        List<String> permList = new ArrayList<>();
        permissions.forEach(p -> permList.add(p.toString()));
        return permList;
    }

    public void addGroup(Group group2) {
        this.groups.add(group2);
    }

    public void setGroup(String groupStr) {
        Group group = Groups.getGroup(groupStr);
        if (group==null) return;
        setGroup(group);
    }

    public void setGroup(Group group2) {
        this.groups.clear();
        this.groups.add(group2);
    }

    public boolean isPermissionSet(String permStr) {
        return permissions.contains(new Permission(permStr));
    }

    public void setPermissionsList(List<String> permissions) {
        this.permissions.clear();
        permissions.forEach(p -> this.permissions.add(new Permission(p)));
    }

    public void setGroupList(List<String> groupList) {
        this.groups.clear();
        groupList.forEach(g -> {
            Group group = Groups.getGroup(g);
            if (group != null) this.groups.add(group);
        });
    }

}
