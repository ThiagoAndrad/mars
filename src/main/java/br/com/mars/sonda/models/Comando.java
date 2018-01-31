package br.com.mars.sonda.models;

public enum Comando {
    L {
        @Override
        public void executa(Sonda sonda) {
            sonda.virarAEsquerda();
        }
    },
    R {
        @Override
        public void executa(Sonda sonda) {
            sonda.virarADireita();
        }
    },
    M {
        @Override
        public void executa(Sonda sonda) {
            sonda.mover();
        }
    };

    public abstract void executa(Sonda sonda);
}
