package sdb1

import org.springframework.dao.DataIntegrityViolationException

class WordController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		println 'params are' + params
		def searchCategory = params.category
		if(searchCategory==null) { searchCategory="root"
			params.category="root"
		}
		
		println  "query " + params.query 
		println  "category " + params.category
		def wordList = Word.createCriteria().list (params) {
			if ( params.query ) {
						ilike("${searchCategory}", "%${params.query}%")
			}
		}
		[wordInstanceList: wordList,wordInstanceTotal: wordList.totalCount]
     
    }

    def create() {
        [wordInstance: new Word(params)]
    }

    def save() {
        def wordInstance = new Word(params)
		if (wordInstance.author ==null)
	wordInstance.author="Ritu Gupta"
if (wordInstance.verifier ==null)
	wordInstance.verifier="Not verified"
        if (!wordInstance.save(flush: true)) {
            render(view: "create", model: [wordInstance: wordInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'word.label', default: 'Word'), wordInstance.id])
        redirect(action: "show", id: wordInstance.id)
    }

    def show(Long id) {
        def wordInstance = Word.get(id)
        if (!wordInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'word.label', default: 'Word'), id])
            redirect(action: "list")
            return
        }

         [wordInstance: wordInstance]
    }

    def edit(Long id) {
        def wordInstance = Word.get(id)
        if (!wordInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'word.label', default: 'Word'), id])
            redirect(action: "list")
            return
        }

        [wordInstance: wordInstance]
    }

    def update(Long id, Long version) {
        def wordInstance = Word.get(id)
		 if (!wordInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'word.label', default: 'Word'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (wordInstance.version > version) {
                wordInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'word.label', default: 'Word')] as Object[],
                          "Another user has updated this Word while you were editing")
                render(view: "edit", model: [wordInstance: wordInstance])
                return
            }
        }

        wordInstance.properties = params

        if (!wordInstance.save(flush: true)) {
            render(view: "edit", model: [wordInstance: wordInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'word.label', default: 'Word'), wordInstance.id])
        redirect(action: "show", id: wordInstance.id)
    }

    def delete(Long id) {
        def wordInstance = Word.get(id)
        if (!wordInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'word.label', default: 'Word'), id])
            redirect(action: "list")
            return
        }

        try {
            wordInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'word.label', default: 'Word'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'word.label', default: 'Word'), id])
            redirect(action: "show", id: id)
        }
    }
}
