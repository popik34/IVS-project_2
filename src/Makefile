.PHONY: clean, test, doc
all:
	ant compile

pack: doc repo install
	mkdir xpospi87_xsalve02_xsamek06
	mv doc repo install xpospi87_xsalve02_xsamek06 
	zip -r xpospi87_xsalve02_xsamek06 xpospi87_xsalve02_xsamek06 
	rm -rf xpospi87_xsalve02_xsamek06

clean:
	ant clean
	rm -rf doc

test:
	ant runTest

doc: clean
	mkdir doc
	doxygen

run:
	ant run

repo:
	mkdir repo
	cd repo && git clone https://github.com/popik34/IVS-project_2.git .

install:
	mkdir install
	cp setup.exe install