package br.com.mars.sonda.models;

public enum DirecaoCardinal {
    N {
        @Override
        public DirecaoCardinal getPontoADireita() {
            return E;
        }

        @Override
        public DirecaoCardinal getPontoAEsquerda() {
            return W;
        }
    },
    E {
        @Override
        public DirecaoCardinal getPontoADireita() {
            return S;
        }

        @Override
        public DirecaoCardinal getPontoAEsquerda() {
            return N;
        }
    },
    S {
        @Override
        public DirecaoCardinal getPontoADireita() {
            return W;
        }

        @Override
        public DirecaoCardinal getPontoAEsquerda() {
            return E;
        }
    },
    W {
        @Override
        public DirecaoCardinal getPontoADireita() {
            return N;
        }

        @Override
        public DirecaoCardinal getPontoAEsquerda() {
            return S;
        }
    };

    public abstract DirecaoCardinal getPontoADireita();

    public abstract DirecaoCardinal getPontoAEsquerda();
}
