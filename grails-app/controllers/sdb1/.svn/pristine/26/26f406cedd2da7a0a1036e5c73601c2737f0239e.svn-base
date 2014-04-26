package sdb1
import java.util.Random
class QuizController {
	def String appendWords (String one , String two) {
		one + '-' + two
	}
	def index() {
		println  flash.message
		println 'params are' + params
		def results = Word.executeQuery('select distinct root from Word')
		def vachan="dweVachan"
		println results
		Random randomno = new Random();
		def root = results.get(randomno.nextInt(results.size()))
		def samp = Word.findAllByRoot(root)
		while (samp.size()  <3) {
			root = results.get(randomno.nextInt(results.size()))
			samp = Word.findAllByRoot(root)
		}
		Collections.shuffle(samp)
		println samp.toString() + samp.size()
	    def choice1, choice2, choice3
		def choice1samp =samp.get(0)
		def choice2samp =samp.get(1)
		def choice3samp =samp.get(2)
		def rottChoice= appendWords(choice1samp.root,choice1samp.rootSanskrit)
		//choose random singular, dual or plural
		if (randomno.nextInt(3)==0) {
			choice1= appendWords(choice1samp.ekVachanSanskrit , choice1samp.ekVachan )
			vachan=' ek Vachan-एकवचन '
			choice2=appendWords(choice2samp.ekVachanSanskrit ,choice2samp.ekVachan)
			choice3=appendWords(choice3samp.ekVachanSanskrit ,choice3samp.ekVachan)
		} else if (randomno.nextInt(3)==1) {
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
		
	//	def dwe=choice1samp.dweVachanSanskrit
	//	def choice1samp =samp.get(1).dweVachanSanskrit
		samp.each() { print " ${it}" }; println "";
		 
		//println samp.get(1))
		//[form:"tritiya", vachan:"eka-vachana", root:"gajah", choice1:"à¤—à¤œà¤ƒ", choice2:"à¤—à¤œà¤¾à¤ƒ", choice3:"à¤—à¤œà¤‚", correct:"à¤—à¤œà¤‚"]
		[form:choice1samp.vibhakti, vachan:vachan, root:rottChoice,choice1:choice1, choice2:choice2, choice3:choice3, correct:choice1]
		
	
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
		def userAnswer= params.answer
		def correct= params.correct
		if( userAnswer==correct)
		 //render text:"you got it"
		  flash.message="you got it"
		  else {
			  
		  flash.message="Oops, correct answer is " +correct
		 
		  }
		  redirect action:"index"
	}
}
