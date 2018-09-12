package pkg01.geradorprova;

final class Discursiva extends Questao{
    private String criteriosCorrecao;
    
    public Discursiva(){}
    
    @Override
    public String retornaQuestao(){
        String retur="";
        retur += "("+this.getPeso()+") - "+this.getPergunta()+"\r\n";
        retur += "R:___________________________________________________\r\n";
        retur += "_____________________________________________________\r\n";
        retur += "_____________________________________________________\r\n";
        retur += "Criterio de avaliacao: "+this.getCriteriosCorrecao()+"\r\n";

        return retur;
    }
    
    public String getCriteriosCorrecao() {
        return criteriosCorrecao;
    }
    public void setCriteriosCorrecao(String criteriosCorrecao) {
        this.criteriosCorrecao = criteriosCorrecao;
    }
}
