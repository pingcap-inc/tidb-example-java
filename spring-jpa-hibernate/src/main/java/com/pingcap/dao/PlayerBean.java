package com.pingcap.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "player_jpa")
public class PlayerBean {
    @Id
    @GeneratedValue(generator="player_id")
    @SequenceGenerator(name="player_id",sequenceName="player_id_seq", allocationSize=1)
    private Long id;
    @Column(name = "coins")
    private Integer coins;
    @Column(name = "goods")
    private Integer goods;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getGoods() {
        return goods;
    }

    public void setGoods(Integer goods) {
        this.goods = goods;
    }
}
