import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { messages } from '../data';
import { NewMessageComponent } from '../new-message/new-message.component';

@Component({
  selector: 'app-default',
  templateUrl: './default.component.html',
  styleUrls: ['./default.component.scss']
})
export class DefaultComponent  {

  messages = messages;

  constructor(
      private snackBar: MatSnackBar,
      private dialog: MatDialog) {}

  onRemove(index: number): void {
    const copy = [...this.messages];
    copy.splice(index, 1);
    this.messages = copy;
  }

  onNewMessage(data: any = {}): void {
    const dialogRef = this.dialog.open(NewMessageComponent, {
      width: '100%',
      panelClass: 'new-message-dialog',
      data
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.snackBar.open('Email sent!', "Sent", {
          duration: 2000
        });
      }
    });
  }

}
