#!/usr/bin/env groovy

import groovy.swing.*
import java.awt.*

new SwingBuilder().edt {
   frame(title: "Rotation Cipher", size: [ 550, 300 ], show:true) {
      borderLayout()
      panel(constraints: BorderLayout.WEST) {
         tableLayout() {
            tr { td { label(text: "Key:") } }
            tr { td { key1 = label(text: "ABCDEFGHIJKLMNOPQRSTUVWXYZ") } }
            tr { td { key2 = label(text: "ABCDEFGHIJKLMNOPQRSTUVWXYZ") } }
            tr { td { label(text: " ")  } }
            tr { td { label(text: "Input:") } }
            tr { td { input = textArea(rows: 3, columns: 40, text: "test") } }
            tr { td { label(text: " ")  } }
            tr { td { label(text: "Output:") } }
            tr { td { output = textArea(rows: 3, columns: 40) } }
            tr { td { label(text: " ")  } }
          
            tr {
               td(align: "right") {
                  panel(layout: new BorderLayout()) {
                     tableLayout(constraints: BorderLayout.EAST) {
                        tr {
                           td { button(text: "Key <<", actionPerformed: { rotateLeft() }) }
                           td { button(text: "Key >>", actionPerformed: { rotateRight() }) }
                           td { button(text: "Encode", actionPerformed: { encode() }) }
                           td { button(text: "Decode", actionPerformed: { decode() }) }
                           td { button(text: "Close", actionPerformed: { dispose() }) }
                        }
                     }
                  }
               }
            }
         }
      }
   }
}

def rotateLeft() {
   key2.text = key2.text[1..-1] + key2.text[0]
}

def rotateRight() {
   key2.with { text = text[size() - 1] + text[0..(size() - 2)] }
}

def encode() {
   output.text = ""
   input.with { text = text.toUpperCase() }

   input.text.each {
      i = key1.text.indexOf(it)
      
      if (i > -1) {
         output.text += key2.text[i]
      } else {
         output.text += it
      }
   }
}

def decode() {
}
