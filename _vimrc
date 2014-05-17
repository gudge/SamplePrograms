set writebackup
"set nobackup
set nu
set ic
set showmatch
set hlsearch
set incsearch
set ts=4
set shiftwidth=2	
set history=10000
set ruler
set scs
set statusline=[%02n]\ %f\ %(\[%M%R%H]%)%=\ %4l,%02c%2V\ %P%*
set laststatus=2
set nocompatible
set cmdheight=2
set nohls
set virtualedit=all
set ai
set smartindent
set paste
"set expandtab
set cinoptions=2
syntax on
set tildeop		
set title		
set ttyfast		
set whichwrap=b,s,<,>,~,[,]	
set wildmenu		
"set textwidth=78	
set wrapmargin=78
set visualbell
syntax on		
filetype on		
filetype indent plugin on	
set showmatch
set report=0	
set autochdir
set backupdir=C:\tmp\vimBackup//
set directory=C:\tmp\swap//
"colorscheme koehler
" Map keys for viewport
map <Ctrl-Down> <Ctrl-w>j
map <Ctrl-Up> <Ctrl-w>k
map <Ctrl-Left> <Ctrl-w>h
map <Ctrl-Right> <Ctrl-w>l
"Full window
au GUIEnter * simalt ~x
 " Autocommands {
if has ("autocmd")
	augroup latex " Latex {
		au!
		au BufNewFile,BufRead *.tex,*.bib setlocal spell
	augroup END " }
endif "has ("autocmd")

function! RightAlignVisual() range
    let lim = [virtcol("'<"), virtcol("'>")]
    let [l, r] = [min(lim), max(lim)]
    exe "'<,'>" 's/\%'.l.'v.*\%<'.(r+1).'v./\=StrPadLeft(submatch(0),r-l+1)'
endfunction
function! StrPadLeft(s, w)
    let s = substitute(a:s, '^\s\+\|\s\+$', '', 'g')
    return repeat(' ', a:w - strwidth(s)) . s
endfunction

:noremap <F12> :silent source $HOME/strip.vim<CR>
:noremap <F11> :silent source $HOME/stringconvert.vim<CR>
:noremap <F10> :silent source $HOME/stringconvert2.vim<CR>
" source ~/.vim/cscope_maps.vim
" } 
" setlocal spell spelllang=en_us
" highlight clear SpellBad
" highlight SpellBad term=standout ctermfg=1 term=underline cterm=underline
" highlight clear SpellCap
" highlight SpellCap term=underline cterm=underline
" highlight clear SpellRare
" highlight SpellRare term=underline cterm=underline
" highlight clear SpellLocal
" highlight SpellLocal term=underline cterm=underline
" set spellfile=~/.vim/spellfile.add
command DiffOrig vert new | set bt=nofile | r # | 0d_ | diffthis
 	\ | wincmd p | diffthis
command Rpy python.exe %
