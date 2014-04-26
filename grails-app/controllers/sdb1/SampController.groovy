package sdb1

import org.springframework.dao.DataIntegrityViolationException

class SampController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [sampInstanceList: Samp.list(params), sampInstanceTotal: Samp.count()]
    }

    def create() {
        [sampInstance: new Samp(params)]
    }

    def save() {
        def sampInstance = new Samp(params)
        if (!sampInstance.save(flush: true)) {
            render(view: "create", model: [sampInstance: sampInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'samp.label', default: 'Samp'), sampInstance.id])
        redirect(action: "show", id: sampInstance.id)
    }

    def show(Long id) {
        def sampInstance = Samp.get(id)
        if (!sampInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'samp.label', default: 'Samp'), id])
            redirect(action: "list")
            return
        }

        [sampInstance: sampInstance]
    }

    def edit(Long id) {
        def sampInstance = Samp.get(id)
        if (!sampInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'samp.label', default: 'Samp'), id])
            redirect(action: "list")
            return
        }

        [sampInstance: sampInstance]
    }

    def update(Long id, Long version) {
        def sampInstance = Samp.get(id)
        if (!sampInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'samp.label', default: 'Samp'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (sampInstance.version > version) {
                sampInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'samp.label', default: 'Samp')] as Object[],
                          "Another user has updated this Samp while you were editing")
                render(view: "edit", model: [sampInstance: sampInstance])
                return
            }
        }

        sampInstance.properties = params

        if (!sampInstance.save(flush: true)) {
            render(view: "edit", model: [sampInstance: sampInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'samp.label', default: 'Samp'), sampInstance.id])
        redirect(action: "show", id: sampInstance.id)
    }

    def delete(Long id) {
        def sampInstance = Samp.get(id)
        if (!sampInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'samp.label', default: 'Samp'), id])
            redirect(action: "list")
            return
        }

        try {
            sampInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'samp.label', default: 'Samp'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'samp.label', default: 'Samp'), id])
            redirect(action: "show", id: id)
        }
    }
}
