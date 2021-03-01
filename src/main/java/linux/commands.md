//
pwd - путь к текущему каталогу

//
cd - change directory
cd ..  на каталог выше
cd ~   в домашний каталог

//
ls  list files and catalogues
ls -R   list files with inner files
ls -a  list with hidden files
ls -al  list all info 
also 'll' command can be used

// 
cat   concatenate 

cat>filename.txt  create new file

cat filename1.txt filename2.txt > filename3.txt concatenate two files into third

// 
cp  copy

cp /home/reaper/file1.txt /home/reaper/tmp  will copy file1.txt to a new file named tmp

// 
mv   move
mv /home/reaper/file1.txt /home/reaper/tmp will MOVE file1.txt to a new file named tmp
also can be used for renaming

//
mkdir   create new directory
mkdir dir1 will create directory named dir1

//
rmdir   delete empty dir (only empty!)

//
rm  delete file

//
touch   creates new file

// 
locate  find file in all dirs

// 
find   -find file in current dir (with subdirs)

// 
grep   find smth in file

grep a newfile.txt will find all 'a' in newfile.txt


// 
sudo   gives root 

//
df    gives info about disk space
df -m


//
du   disk usage


// 
head   shows first 10 rows of file

head -n 5 filename.txt    only 5 first rows

//tail

the same but last

//
diff   rows difference between files

diff file1.txt file2.txt

//
tar    for archiving

//
chmod   change mode (access to read, write)

//
chown   change owner  


// 
ps ux   -- to see process pid

//
ping

//
wget   to get smth from browser e.g. download file

// 
uname


//
top    shows processes


//
history   shows command history


//
man   manual for linux command


//
echo

// 
zip 
unzip


//hostname



//
clear    clears the terminal