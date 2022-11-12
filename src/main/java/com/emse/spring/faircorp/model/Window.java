package com.emse.spring.faircorp.model;


import javax.persistence.*;

@Entity
@Table(name = "RWINDOW")
    public class Window {
       @Id
       @GeneratedValue
       private Long id;

    @Column(nullable=false)
        private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
        private WindowStatus windowStatus;

    public Window() {
    }

    public Window(Room room, String name, WindowStatus windowStatus) {
            this.name = name;
            this.windowStatus = windowStatus;
            this.room = room;
        }

        public Window(String name, WindowStatus status) {
            this.windowStatus = status;
            this.name = name;
        }


    public Long getId() {
            return this.id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public WindowStatus getWindowStatus() {
            return windowStatus;
        }

        public void setWindowStatus(WindowStatus windowStatus) {
            this.windowStatus = windowStatus;
        }
        @JoinColumn(nullable=false)
        @ManyToOne
        private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}



