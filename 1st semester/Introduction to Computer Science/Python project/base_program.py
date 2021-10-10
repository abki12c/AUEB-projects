from mylib import play_game,create_deck,find_score,print_score,first_cards,new_closed_deck
import random
players_number=int(input('Ποιός είναι ο αριθμός των παικτών; '))

# check if the players_number exceeds the maximum number of players,which is 5
while players_number>5 or players_number<1:
    print('Το παιχνίδι αγωνία παίζεται με μέγιστο αριθμό παικτών 5 και ελάχιστο 1')
    players_number=int(input('Εισάγετε ξανά τον αριθμό των παικτών:'))

#saves the name of each player
deck=create_deck()
list_player_names, player_name=[],[]
for i in range(players_number):
    print('Ποιό είναι το όνομα του',i+1,'ου παίκτη;')
    name=input('')
    player_name.append(name)
    list_player_names.append(player_name[i])
if players_number==1:
    print('Ο δεύτερος παίκτης είναι ο Υπολογιστής')
    list_player_names.append('Υπολογιστής')
    players_number+=1

list_player_names.sort()
closed_deck=deck.copy()
#Giving 7 cards to each player
player_cards=[]
for i in range(players_number):
    cards=first_cards(closed_deck)
    player_cards.append(cards)
    closed_deck=new_closed_deck(player_cards,i,closed_deck)
#initializes open deck,open card and closed deck
open_deck=[random.choice(closed_deck)]
open_card=open_deck[0]
closed_deck.remove(open_card)
#play one round of the game
play_game(list_player_names,open_deck,open_card,player_cards,closed_deck,players_number)

score=find_score(list_player_names,player_cards,players_number)
score_values=[]
for i in range(players_number):
    score_values.append(score[list_player_names[i]])
print_score(score)
#sorts the score dictionary based on its value,which is the score points of the person
score=sorted(score.items(), key=lambda x: x[1])
winner_score=score[0][1]
#continues to play the game until there is a clear winner
while score_values.count(winner_score)>1:
    print('Κανένας ξεκάθαρος νικητής.Εκκίνηση νέου γύρου:')
    closed_deck=deck.copy()
    #Giving 7 cards to each player
    player_cards=[]
    for i in range(players_number):
        cards=first_cards(closed_deck)
        player_cards.append(cards)
        closed_deck=new_closed_deck(player_cards,i,closed_deck)
    #initializes open deck,open card and closed deck
    open_deck=[random.choice(closed_deck)]
    open_card=open_deck[0]
    closed_deck.remove(open_card)

    play_game(list_player_names,open_deck,open_card,player_cards,closed_deck,players_number)
    score=find_score(list_player_names,player_cards,players_number)
    score_values=[]
    for i in range(players_number):
        score_values.append(score[list_player_names[i]])
    print_score(score)
    score=sorted(score.items(),key=lambda x: x[1])
    winner_score=score[0][1]
winner=score[0][0]
print('Νικητής ο',winner,'με σκόρ',winner_score)