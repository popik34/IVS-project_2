all:
	cd src_code && ant compile

pack: doc repo
	zip -r xpospi87_xsalve02_xsamek06 doc repo
	rm -rf doc
	rm -rf repo

clean:
	cd src_code && ant clean

test:
	cd src_code && ant run_tests
doc:
	mkdir doc
	
run:
	cd src_code && ant run

repo:
	mkdir repo
	cd repo && git clone https://github.com/popik34/IVS-project_2.git .