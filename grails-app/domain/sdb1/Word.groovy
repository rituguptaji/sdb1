package sdb1

class Word {
	String root, rootMeaning, ekVachan, ekVachanMeaning, dweVachan,dweVachanMeaning, bahuVachan,
	 bahuVachanMeaning, ekVachanSanskrit, dweVachanSanskrit, bahuVachanSanskrit, vibhakti, antak, rootSanskrit, gender,author, verifier
    static constraints = {root (blank:false)
rootSanskrit (blank:false)
rootMeaning (blank:false)
gender(inList:["m-पु", "f-स्त्रि" ,"n-नपु"], blank:false)
antak(inList:[  "अ", "आ",  "इ", "ई", "उ", "ऊ", "ऋ", "ए", "ऐ", "ओ", "औ"  ], blank:false)
vibhakti (inList:["1-प्रथमा", "2-द्वितिया", "3-तृतीया", "4-चतुर्थ", "5-पञ्चमी", "6-षष्टि", "7-सप्तमी", "8-अस्टमी" ],blank:false)
ekVachan()
ekVachanSanskrit()
ekVachanMeaning()

    }
}
