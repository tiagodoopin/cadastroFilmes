package filmes

import org.springframework.dao.DataIntegrityViolationException

class FilmesController {

    static allowedMethods = [save: "POST"]

    def index() {
        redirect(action: "create", params: params)
    }

    def create(){
        def instance = new Filmes()
        render(view: 'create', model: ['instance': instance])
    }

    def save(){
        def suple = new Filmes()
        suple.nome = params.nome
        suple.ano = params.ano
        suple.save(flush: true)
        redirect(action: 'list')
    }

    def list(){
        def show = Filmes.getAll()
        render(view: 'list', model: ['instance': show])
    }

    def delete(){
        print params
        def filmeInstance = Filmes.findById(params.id)
        print params
        filmeInstance.delete()
        redirect(action: 'list')
    }

}
