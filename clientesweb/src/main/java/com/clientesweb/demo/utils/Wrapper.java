    package com.clientesweb.demo.utils;


    import lombok.Getter;
    import lombok.Setter;

    import java.io.Serializable;

    @Getter
    @Setter
    public class Wrapper implements Serializable {

        private boolean OK;
        private String descripcion;
        private Object data;


        public Wrapper(boolean OK, String descripcion, Object data) {
            super();
            this.OK = OK;
            this.descripcion=descripcion;
            this.data=data;
        }

        public Wrapper() {
            super();
        }


        /**
         *
         */
        private static final long serialVersionUID = -1764598016620660340L;
    }
