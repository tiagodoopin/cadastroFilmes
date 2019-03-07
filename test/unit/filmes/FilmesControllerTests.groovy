package filmes


import org.junit.*
import grails.test.mixin.*

@TestFor(FilmesController)
@Mock(Filmes)
class FilmesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/filmes/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.filmesInstanceList.size() == 0
        assert model.filmesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.filmesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.filmesInstance != null
        assert view == '/filmes/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/filmes/show/1'
        assert controller.flash.message != null
        assert Filmes.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/filmes/list'

        populateValidParams(params)
        def filmes = new Filmes(params)

        assert filmes.save() != null

        params.id = filmes.id

        def model = controller.show()

        assert model.filmesInstance == filmes
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/filmes/list'

        populateValidParams(params)
        def filmes = new Filmes(params)

        assert filmes.save() != null

        params.id = filmes.id

        def model = controller.edit()

        assert model.filmesInstance == filmes
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/filmes/list'

        response.reset()

        populateValidParams(params)
        def filmes = new Filmes(params)

        assert filmes.save() != null

        // test invalid parameters in update
        params.id = filmes.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/filmes/edit"
        assert model.filmesInstance != null

        filmes.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/filmes/show/$filmes.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        filmes.clearErrors()

        populateValidParams(params)
        params.id = filmes.id
        params.version = -1
        controller.update()

        assert view == "/filmes/edit"
        assert model.filmesInstance != null
        assert model.filmesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/filmes/list'

        response.reset()

        populateValidParams(params)
        def filmes = new Filmes(params)

        assert filmes.save() != null
        assert Filmes.count() == 1

        params.id = filmes.id

        controller.delete()

        assert Filmes.count() == 0
        assert Filmes.get(filmes.id) == null
        assert response.redirectedUrl == '/filmes/list'
    }
}
