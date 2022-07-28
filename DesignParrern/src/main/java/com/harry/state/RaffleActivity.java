package com.harry.state;

import lombok.Data;

@Data
public class RaffleActivity {

    // state 表示活动当前的状态，是变化
    State state = null;

    // 奖品数量
    int count = 0;
    // 四个属性，表示四种状态
    State noRafflleState = new NoRaffleState(this);
    State canRaffleState = new CanRaffleState(this);
    State dispenseState = new DispenseState(this);
    State dispensOutState = new DispenseOutState(this);

    public RaffleActivity(Integer count) {
        this.state = getNoRafflleState();
        this.count = count;
    }

    // 扣分, 调用当前状态的 deductMoney
    public void debuctMoney(){
        state.deductMoney();
    }
    public void raffle(){
        if(state.raffle()){
            //领取奖品
            state.dispensePrize();
        }
    }
}
