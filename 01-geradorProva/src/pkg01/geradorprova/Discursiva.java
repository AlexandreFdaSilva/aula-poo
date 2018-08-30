package pkg01.geradorprova;

final class Discursiva extends Questao{
    private String criteriosCorrecao;
    
    public Discursiva(){}
    
    public String getCriteriosCorrecao() {
        return criteriosCorrecao;
    }
    public void setCriteriosCorrecao(String criteriosCorrecao) {
        this.criteriosCorrecao = criteriosCorrecao;
    }
}
