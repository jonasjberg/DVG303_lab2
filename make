#!/usr/bin/env bash

latexmk tex/DVG303_lab2.tex -outdir=build -pdf -pdflatex="pdflatex -interaction=nonstopmode -shell-escape"
