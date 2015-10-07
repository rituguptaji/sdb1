package sdb1
import java.util.Random
class QuizController {
	def String appendWords (String one , String two) {
		one + '-' + two
	}
	def list () {
		println 'params for list are' + params
		def correctAnswers = params.correctAnswers
		def totalQuestions = params.totalQuestions
		if (correctAnswers == null) correctAnswers = "0"
		if (totalQuestions == null) totalQuestions = "0"
		def results = Word.executeQuery('select distinct root from Word group by root having count(*)>=3' )
		//def vibhaktis  = Word.executeQuery('select distinct vibhakti from Word');
		[words: results, correctAnswers: correctAnswers, totalQuestions:totalQuestions]
	}
	def chooseRoots() {
		println 'params  are' + params
		def correctAnswers = params.correctAnswers
		def totalQuestions = params.totalQuestions
		if (correctAnswers == null) correctAnswers = "0"
		if (totalQuestions == null) totalQuestions = "0"
		def selectedValues = params.chose
		def vibhakti = params.vibhakti
		List valuelist = new ArrayList()
		
		if(selectedValues instanceof String) {
			valuelist.add(selectedValues)
		} else {
			valuelist = selectedValues as List
		}
		def chose= valuelist.collect().join(',')
//	def chose= params.chose.collect().join(',')

		redirect(action: "index", params:[roots:chose, correctAnswers: correctAnswers, totalQuestions:totalQuestions, vibhakti:vibhakti])
	}
	def index() {
		println  flash.message
		println 'params for index are' + params
		def vibhakti = params.vibhakti
		if( (vibhakti == '') || ( vibhakti =="all") )vibhakti= null
		def correctAnswers = params.correctAnswers
		def totalQuestions = params.totalQuestions
		if (correctAnswers == null) correctAnswers = "0"
		if (totalQuestions == null) totalQuestions = "0"
		def results =[]// ['ashva', 'pati' ]
		def res  = []
		def roots = params.roots
			if( (roots == '') || ( roots =="all") )roots= null
		if(roots == null) {
			println "getting roots from db"
		 results = Word.executeQuery('select distinct root from Word group by root having count(*)>=3')
		 roots= results.collect().join(',')
		 
		} else{
	     res = roots.split(',').collect{it as String}
		results = res
		results.remove("all")
		}
	
		def vachan="dweVachan"
		def chosen  = 0
		def samp =[]
		println 'class is ' + results.getClass()
		//println results + results.count
		Random randomno = new Random();
		def root = results.get(randomno.nextInt(results.size()))
		def choice1, choice2, choice3,rottChoice, correct
		def choice1samp, choice2samp, choice3samp
		println "root before samp" + root
			//include the vibhakti in our list
		if (vibhakti != null ) {
			
			def ourChoice= []
			while (ourChoice==[]){
				
				root = results.get(randomno.nextInt(results.size()))
			ourChoice=	Word.findAllByRootAndVibhakti(root,vibhakti)
			println "ourChoice" + ourChoice
			samp=	Word.findAllByRootAndVibhaktiNotEqual(root,vibhakti)
			Collections.shuffle(samp)
			def random =randomno.nextInt(3)
			if (random==0) {
				choice1samp=ourChoice.get(0)
				choice2samp =samp.get(0)
				choice3samp =samp.get(1)
				chosen = 1
			}else if (random==1) {
				choice2samp=ourChoice.get(0)
				choice1samp =samp.get(0)
				choice3samp =samp.get(1)
				chosen = 2
			}else if (random==2) {
				choice3samp=ourChoice.get(0)
				choice1samp =samp.get(0)
				choice2samp =samp.get(1)
				chosen = 3
			}
			}
			println 'vibhakti is not null' + vibhakti + root + choice1samp + choice2samp + choice3samp + samp + ourChoice
			

		} else {
			root = results.get(randomno.nextInt(results.size()))
			samp = Word.findAllByRoot(root)

			Collections.shuffle(samp)
			println samp.toString() + samp.size()

			 choice1samp =samp.get(0)
			 choice2samp =samp.get(1)
			 choice3samp =samp.get(2)
		}
		def form 
		    rottChoice= appendWords(choice1samp.root,choice1samp.rootSanskrit)
		//choose random singular, dual or plural
			def random =randomno.nextInt(3)
		if (random==0) {
			choice1= appendWords(choice1samp.ekVachanSanskrit , choice1samp.ekVachan )
			vachan=' ek Vachan-एकवचन '
			choice2=appendWords(choice2samp.ekVachanSanskrit ,choice2samp.ekVachan)
			choice3=appendWords(choice3samp.ekVachanSanskrit ,choice3samp.ekVachan)
		} else if (random==1) {
			choice1=appendWords(choice1samp.dweVachanSanskrit , choice1samp.dweVachan )
			vachan=' dwe Vachan-द्विवचन '
			choice2=appendWords(choice2samp.dweVachanSanskrit ,choice2samp.dweVachan)
			choice3=appendWords(choice3samp.dweVachanSanskrit ,choice3samp.dweVachan)

		} else  {
			choice1=appendWords(choice1samp.bahuVachanSanskrit , choice1samp.bahuVachan )
			vachan=' bahu Vachan-बहुवचन '
			choice2=appendWords(choice2samp.bahuVachanSanskrit ,choice2samp.bahuVachan)
			choice3=appendWords(choice3samp.bahuVachanSanskrit ,choice3samp.bahuVachan)
	
		}
		if (vibhakti != null ) {
			form= vibhakti
			if (chosen ==1) {
				correct = choice1
			} else if (chosen ==2) {
			correct = choice2
			} else if (chosen ==3){
			correct = choice3
			}
			
		} else {	
			random =randomno.nextInt(3)
			//choose random which vibhakti we are after
			if (random==0) {
				form = choice1samp.vibhakti
				correct = choice1
			} else if (random==1) {
				form = choice2samp.vibhakti
				correct =choice2
			}
			else {
				form = choice3samp.vibhakti
				correct =choice3
			}
		}
	//	def dwe=choice1samp.dweVachanSanskrit
	//	def choice1samp =samp.get(1).dweVachanSanskrit
		samp.each() { print " ${it}" }; println "";
		 
		//println samp.get(1))
		//[form:"tritiya", vachan:"eka-vachana", root:"gajah", choice1:"à¤—à¤œà¤ƒ", choice2:"à¤—à¤œà¤¾à¤ƒ", choice3:"à¤—à¤œà¤‚", correct:"à¤—à¤œà¤‚"]
		[form:form, vachan:vachan, root:rottChoice,choice1:choice1, choice2:choice2, choice3:choice3, correct:correct, roots: roots, correctAnswers: correctAnswers, totalQuestions:totalQuestions, vibhakti:vibhakti]
		
	
	}
	/*
    def index() { 
		println  flash.message
		println 'params are' + params
		def results = Word.executeQuery('select distinct root from Word')
		
		println results
		def samp = Word.findAllByRoot('gajah')
		println samp.toString() + samp.size()
		Random randomno = new Random();
		def choice1samp =samp.get(randomno.nextInt(2)).dweVachanSanskrit
	//	def choice1samp =samp.get(1).dweVachanSanskrit
		samp.each() { print " ${it}" }; println "";
		
		//println samp.get(1))
		//[form:"tritiya", vachan:"eka-vachana", root:"gajah", choice1:"à¤—à¤œà¤ƒ", choice2:"à¤—à¤œà¤¾à¤ƒ", choice3:"à¤—à¤œà¤‚", correct:"à¤—à¤œà¤‚"]
		[form:"tritiya", vachan:"eka-vachana", root:"gajah",choice1:choice1samp, choice2:"à¤—à¤œà¤¾à¤ƒ", choice3:"à¤—à¤œà¤‚", correct:"à¤—à¤œà¤‚"]
		
	
	} */
	def answer() {
		println 'params in answer are' + params
		def userAnswer= params.answer
		def correct= params.correct
		def roots = params.roots
		def correctAnswers = params.correctAnswers as Integer
		def totalQuestions = params.totalQuestions as Integer
		totalQuestions+=1
		
		println 'params in answer are' + correctAnswers.getClass()
		if( userAnswer==correct) {
		 //render text:"you got it"
		  flash.message="you got it"
		  correctAnswers +=1
		}
		  else {
			  
		  flash.message="Oops, correct answer is " +correct
		 
		  }
		  params.correctAnswers=correctAnswers.toString()
		  params.totalQuestions= totalQuestions.toString()
		  redirect action:"index", params : params
	}
}
