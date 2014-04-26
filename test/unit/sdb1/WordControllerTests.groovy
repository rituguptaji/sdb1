package sdb1



import org.junit.*
import grails.test.mixin.*

@TestFor(WordController)
@Mock(Word)
class WordControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/word/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.wordInstanceList.size() == 0
        assert model.wordInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.wordInstance != null
    }

    void testSave() {
        controller.save()

        assert model.wordInstance != null
        assert view == '/word/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/word/show/1'
        assert controller.flash.message != null
        assert Word.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/word/list'

        populateValidParams(params)
        def word = new Word(params)

        assert word.save() != null

        params.id = word.id

        def model = controller.show()

        assert model.wordInstance == word
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/word/list'

        populateValidParams(params)
        def word = new Word(params)

        assert word.save() != null

        params.id = word.id

        def model = controller.edit()

        assert model.wordInstance == word
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/word/list'

        response.reset()

        populateValidParams(params)
        def word = new Word(params)

        assert word.save() != null

        // test invalid parameters in update
        params.id = word.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/word/edit"
        assert model.wordInstance != null

        word.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/word/show/$word.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        word.clearErrors()

        populateValidParams(params)
        params.id = word.id
        params.version = -1
        controller.update()

        assert view == "/word/edit"
        assert model.wordInstance != null
        assert model.wordInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/word/list'

        response.reset()

        populateValidParams(params)
        def word = new Word(params)

        assert word.save() != null
        assert Word.count() == 1

        params.id = word.id

        controller.delete()

        assert Word.count() == 0
        assert Word.get(word.id) == null
        assert response.redirectedUrl == '/word/list'
    }
}
