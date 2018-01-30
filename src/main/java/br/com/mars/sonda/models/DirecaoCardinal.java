package br.com.mars.sonda.models;

public enum DirecaoCardinal {
    N {
        @Override
        public DirecaoCardinal getPontoADireita() {
            return E;
        }
    },
    E {
        @Override
        public DirecaoCardinal getPontoADireita() {
            return S;
        }
    },
    S {
        @Override
        public DirecaoCardinal getPontoADireita() {
            return W;
        }
    },
    W {
        @Override
        public DirecaoCardinal getPontoADireita() {
            return N;
        }
    };

    public abstract DirecaoCardinal getPontoADireita();
}
