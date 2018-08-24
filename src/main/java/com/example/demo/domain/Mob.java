package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public static int koukando;
    public String message;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Integer getKoukando(){
        return koukando;
    }
    public void setKoukando(int koukando){
        this.koukando = koukando;
    }
    @Override
    public String toString(){
        return "Mob [id=" + id + ", name=" + "]";
    }
}
