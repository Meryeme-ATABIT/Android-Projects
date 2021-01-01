package com.example.pokemon.models;
import java.io.Serializable;

    public class Pokemon implements Serializable {

        private Integer id;
        private String name;
        private String avatar;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public Pokemon(Integer id, String name, String avatar) {
            this.id = id;
            this.name = name;
            this.avatar = avatar;
        }
   }

