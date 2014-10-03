#! C:\Work\bin2\bash -x

git clone ssh://sbanerjee@git.eclipse.org:29418/jdt/eclipse.jdt.core.git
git config user.email shankhba@in.ibm.com
git config remote.review.url ssh://sbanerjee@git.eclipse.org:29418/jdt/eclipse.jdt.core.git
git config remote.review.push HEAD:refs/for/master
