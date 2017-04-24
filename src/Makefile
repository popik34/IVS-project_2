.PHONY: clean, test
all:
	ant compile

pack: doc repo
	zip -r xpospi87_xsalve02_xsamek06 doc repo
	rm -rf doc
	rm -rf repo

clean:
	ant clean
	rm -rf doc

test:
	ant runTest

doc:
	mkdir doc
	
run:
	ant run

repo:
	mkdir repo
	cd repo && git clone https://github.com/popik34/IVS-project_2.git .