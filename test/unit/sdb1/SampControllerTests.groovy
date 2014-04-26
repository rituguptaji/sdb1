package sdb1



import org.junit.*
import grails.test.mixin.*

@TestFor(SampController)
@Mock(Samp)
class SampControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/samp/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.sampInstanceList.size() == 0
        assert model.sampInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.sampInstance != null
    }

    void testSave() {
        controller.save()

        assert model.sampInstance != null
        assert view == '/samp/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/samp/show/1'
        assert controller.flash.message != null
        assert Samp.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/samp/list'

        populateValidParams(params)
        def samp = new Samp(params)

        assert samp.save() != null

        params.id = samp.id

        def model = controller.show()

        assert model.sampInstance == samp
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/samp/list'

        populateValidParams(params)
        def samp = new Samp(params)

        assert samp.save() != null

        params.id = samp.id

        def model = controller.edit()

        assert model.sampInstance == samp
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/samp/list'

        response.reset()

        populateValidParams(params)
        def samp = new Samp(params)

        assert samp.save() != null

        // test invalid parameters in update
        params.id = samp.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/samp/edit"
        assert model.sampInstance != null

        samp.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/samp/show/$samp.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        samp.clearErrors()

        populateValidParams(params)
        params.id = samp.id
        params.version = -1
        controller.update()

        assert view == "/samp/edit"
        assert model.sampInstance != null
        assert model.sampInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/samp/list'

        response.reset()

        populateValidParams(params)
        def samp = new Samp(params)

        assert samp.save() != null
        assert Samp.count() == 1

        params.id = samp.id

        controller.delete()

        assert Samp.count() == 0
        assert Samp.get(samp.id) == null
        assert response.redirectedUrl == '/samp/list'
    }
}
