package com.example.pokemon.models;


    import java.io.Serializable;

    public class Pokemon implements Serializable {

        private static final long serialVersionUID = -1164282896191478617L;

        private Integer id;
        private String name;
        private String avatar;

        public Pokemon(Integer id, String name, String avatar) {
            this.id = id;
            this.name = name;
            this.avatar = avatar;
        }


    }

