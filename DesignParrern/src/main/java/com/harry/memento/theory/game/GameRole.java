package com.harry.memento.theory.game;

import lombok.Data;

@Data
public class GameRole {
    private int vit;
    private int def;

    //创建 Memento ,即根据当前的状态得到 Memento
    public Memento createMemento() {
        return new Memento(vit, def);
    }
    //从备忘录对象，恢复 GameRole 的状态
    public void recoverGameRoleFromMemento(Memento memento) {
        this.vit = memento.getVit();
        this.def = memento.getDef();
    }
    //显示当前游戏角色的状态
    public void display() {
        System.out.println("游戏角色当前的攻击力：" + this.vit + " 防御力: " + this.def);
    }
}
