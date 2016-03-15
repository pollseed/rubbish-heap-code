#### cut tell hyphen
N = ^(0[0-9]0)-?([0-9]{4}?)-?([0-9]{4}?)$
P = $1$2$3

#### split domain,mail
N = (.*)@(.*)\.com
P = domain[$2], mail[$1]

