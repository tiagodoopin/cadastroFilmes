package filmes

class Filmes {

    String nome
    String ano

    static constraints = {
        nome nullable: false,blank: false
        ano nullable: false,blank: false
    }
}
