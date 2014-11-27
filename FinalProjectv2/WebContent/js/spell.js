		function ActivSpellClass() {
			this.init();	
		}

		ActivSpellClass.prototype = new Object();
		ActivSpellClass.prototype.init = function() {
			this.argsIndex = -1;
			this.fieldRefs = new Array();
			this.ignore = new Array();
			this.change = new Array();
			this.changeto = new Array();
			this.replacements = new Array();
		}
		
		ActivSpell = new ActivSpellClass();
		
		function nextField() {

		}
	
		function spell() 
		{	
			ActivSpell.fieldRefs = arguments;
			
			//override nextField since registering onpropertychange fires itself
			nextField = function() {				
				var _elem;

				// do not spell check hidden fields
				do {
					ActivSpell.argsIndex++;
					
					if(ActivSpell.argsIndex >= ActivSpell.fieldRefs.length)
						break;
					
					try {
						_elem = eval(ActivSpell.fieldRefs[ActivSpell.argsIndex].slice(0, ActivSpell.fieldRefs[ActivSpell.argsIndex].length-6));
					}catch(e) {
						break;
					}
				} while (  _elem.type == "hidden" );
				
				
//				if (eval(ActivSpell.fieldRefs[ActivSpell.argsIndex].length == 0)) {
//					alert("empty field");
//					if (ActivSpell.argsIndex < ActivSpell.fieldRefs.length) {
//						ActivSpell.argsIndex++;
//						nextField();
//					}
//				}
				
				if(ActivSpell.argsIndex < ActivSpell.fieldRefs.length) {
				ActivSpellWin = window.open("/Script/spellchecker/window.cfm?jsvar=" + ActivSpell.fieldRefs[ActivSpell.argsIndex], "ActivSpellWin", "height=230,width=450,status=no,toolbar=no,menubar=no,location=no");
				} else {
					spellCheckComplete();
				}
			}
			
			//index ActivSpell.argsIndex
			ActivSpell.argsIndex++;
			
//			if (eval(ActivSpell.fieldRefs[ActivSpell.argsIndex].length == 0)) {
//				alert("empty field");
//				if (ActivSpell.argsIndex < ActivSpell.fieldRefs.length) {
//					ActivSpell.argsIndex++;
//					nextField();
//				}
//			}
			
			//send the first field to spellcheck
			ActivSpellWin = window.open("/Script/spellchecker/window.cfm?jsvar=" + ActivSpell.fieldRefs[0], "ActivSpellWin", "height=230,width=450,status=no,toolbar=no,menubar=no,location=no");	
		}
		
		function spellCheckComplete() {
			alert("Spell Check Complete!");
			
			ActivSpell.argsIndex = -1;
			//ActivSpell.fieldRefs = null;
			nextField = function() {}
			ActivSpellWin.close();
		}