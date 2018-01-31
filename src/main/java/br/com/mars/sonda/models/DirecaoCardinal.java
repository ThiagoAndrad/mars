package br.com.mars.sonda.models;

public enum DirecaoCardinal {
    N(new MovimentacaoNorte()) {
        @Override
        public DirecaoCardinal getPontoADireita() {
            return E;
        }

        @Override
        public DirecaoCardinal getPontoAEsquerda() {
            return W;
        }
    },
    E(new MovimentacaoLeste()) {
        @Override
        public DirecaoCardinal getPontoADireita() {
            return S;
        }

        @Override
        public DirecaoCardinal getPontoAEsquerda() {
            return N;
        }
    },
    S(new MovimentacaoSul()) {
        @Override
        public DirecaoCardinal getPontoADireita() {
            return W;
        }

        @Override
        public DirecaoCardinal getPontoAEsquerda() {
            return E;
        }
    },
    W(new MovimentacaoOeste()) {
        @Override
        public DirecaoCardinal getPontoADireita() {
            return N;
        }

        @Override
        public DirecaoCardinal getPontoAEsquerda() {
            return S;
        }
    };

    private final  RegraDeMovimentacao regraDeMovimentacao;

    DirecaoCardinal(RegraDeMovimentacao regraDeMovimentacao){
        this.regraDeMovimentacao = regraDeMovimentacao;
    }

    public abstract DirecaoCardinal getPontoADireita();

    public abstract DirecaoCardinal getPontoAEsquerda();

    public RegraDeMovimentacao getRegraDeMovimentacao() {
        return this.regraDeMovimentacao;
    }
}
