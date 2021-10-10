import random
def play_game(list_player_names,open_deck,op_card,player_cards,closed_deck,players_number):
    """plays a round of the game"""
    global p_cards,open_card,player,player_index
    open_card=op_card
    player=list_player_names[0]
    player_index=0
    while none_over50pt(list_player_names,player_cards,players_number)==True and none_has_no_cards(player_cards,players_number)==True:
        p_cards=player_cards[player_index]
        print('Σειρά σου',player)
        if player=='Υπολογιστής':
            card_number=random.randint(0,len(p_cards)-1)
            print('Η ανοικτή κάρτα είναι:', open_card)
        else:
            print('Η τράπουλά σου:')
            print_cards()
            print('Η ανοικτή κάρτα είναι:', open_card)
            card_number=int(input('Δώσε την κάρτα της επιλογής σου(αριθμό κάρτας):'))
            #check for the right card value
            while card_number>=len(player_cards[player_index]) or card_number<0:
                card_number=int(input('Ο συγκεκριμένος αριθμος κάρτας δεν υπάρχει.Εισάγετε ξανά:'))
        given_card=p_cards[card_number]
        #does the right action for the card given
        if card_is_special(given_card)==True:
            print_description(given_card)
            card_effect(given_card,list_player_names,closed_deck,open_deck,player_cards)
        else:
            if matches(given_card,open_card)==True:
                print('Η κάρτα σου ταιριάζει με την ανοικτή κάρτα!')
                open_card=p_cards[card_number]
            else:
                print('Η κάρτα σου δεν ταιριάζει με την ανοικτή κάρτα :(')
                print('*Πάσο*')
                draw_card(closed_deck,p_cards,open_deck,list_player_names[player_index],list_player_names)
            #updates next player and next player index
            player=next_player(player,list_player_names,player_index,open_card,given_card)
            player_index=list_player_names.index(player)
        if matches(open_card,given_card)==True:
            open_deck.append(open_card)
            p_cards.pop(card_number)

def create_deck():
    """creates the deck"""
    deck=[]
    card_series={'♥','♣','♦','♠'}
    for series in card_series:
        deck.append(('A',series,11))
        for card_number in range(2,11):
            deck.append((str(card_number),series,card_number))
        deck.append(('K',series,10))
        deck.append(('J',series,10))
        deck.append(('Q',series,10))
    return deck

def matches(card1,card2):
    """checks if card1 and card2 match"""
    return card1[0]==card2[0] or card1[1]==card2[1]

def none_has_no_cards(player_cards,players_number):
    """checks if every player has cards on their hands

    >>> p1_cards=[('A', '♥', 11),('K', '♣', 10), ('5', '♥', 5), ('7', '♣', 7), ('8', '♣', 8), ('5', '♦', 5),('J', '♠', 10)]
    >>> p2_cards=[('A', '♥', 11),('4', '♦', 4), ('2', '♠', 2), ('3', '♣', 3), ('9', '♣', 9), ('5', '♦', 5),('A', '♠', 11)]
    >>> p3_cards=[]
    >>> player_cards=[p1_cards,p2_cards,p3_cards]
    >>> none_has_no_cards(player_cards,3)
    False
    """
    for i in range(players_number):
        if len(player_cards[i])==0:
            return False
    return True

def none_over50pt(list_player_names,player_cards,players_number):
    """checks if every player's score is not over 50 pt
     >>> p1_cards=[('A', '♥', 11),('K', '♣', 10), ('5', '♥', 5), ('7', '♣', 7), ('8', '♣', 8), ('5', '♦', 5),('J', '♠', 10)]
    >>> p2_cards=[('A', '♥', 11),('4', '♦', 4), ('2', '♠', 2), ('3', '♣', 3), ('9', '♣', 9), ('5', '♦', 5),('A', '♠', 11)]
    >>> p3_cards=[('Q', '♠', 11),('K', '♣', 10), ('2', '♠', 2), ('10', '♣', 10), ('6', '♣', 6), ('4', '♦', 4),('K', '♠', 10)]
    >>> player_cards=[p1_cards,p2_cards,p3_cards]
    >>> list_player_names=['Mark','Mary','Henry']
    >>> none_over50pt(list_player_names,player_cards,3)
    False
    """
    score=find_score(list_player_names,player_cards,players_number)
    for i in range(players_number):
        if score[list_player_names[i]]>50:
            return False
    return True

def card_is_special(given_card):
    """checks if the card is special

    >>> given_card=('A', '♥', 11)
    >>> card_is_special(given_card)
    True
    """
    return given_card[0]=='A' or given_card[0]=='7' or given_card[0]=='8' or given_card[0]=='9'

def draw_card(closed_pile,p_cards,open_deck,player_name,list_player_names):
    global closed_deck
    if len(closed_pile)!=0:
        print('*Ο παίκτης',player_name,'παίρνει μια επιπλέον κάρτα*')
        card=random.choice(closed_pile)
        closed_pile.remove(card)
        p_cards.append(card)
    else:
        print('Η κλεισή στοίβα καρτών τελείωσε.Ολες οι κάρτες της ανοικτής τράπυκλας εκτός απο το ανοικτό φύλλο θα ανακατευθούν και θα χρησιμοποιηθούν ως κλειστή στοίβα.')
        open_deck.remove(open_card)
        random.shuffle(open_deck)
        closed_pile=open_deck
        open_deck.clear()
        open_deck.append(open_card)
        draw_card(closed_pile,p_cards,open_deck,list_player_names[player_index],list_player_names)
    closed_deck=closed_pile

def print_description(given_card):
    """ prints the description of the specific special card """
    if given_card[0]=='A':
        print('Ο παίκτης μπορεί να ρίξει άσσο άσχετα με τη σειρά του ανοιχτού φύλλου. Αν ένας παίκτης ρίξει άσσο, τότε μπορεί να επιλέξει ποια θα είναι στο εξής η σειρά του ανοιχτού φύλλου (π.χ. κούπα, σπαθί). Έτσι, ο επόμενος παίκτης θα πρέπει να παίξει με την επιλεγμένη σειρά. Σε περίπτωση που εμφανιστεί άσσος ως πρώτο ανοιχτό φύλλο κατά την έναρξη του παιχνιδιού, τότε αντιμετωπίζεται ως ένα απλό φύλλο.')
    elif given_card[0]=='7':
        print('Αν ένας παίκτης ρίξει 7, τότε ο επόμενος παίκτης τραβάει δύο φύλλα από την κλειστή τράπουλα. Αν ο παίκτης που θα πάρει τα φύλλα δεν έχει κατάλληλο φύλλο για να παίξει, τότε θα τραβήξει κανονικά ένα φύλλο από την κλειστή τράπουλα. Αν μεταξύ των φύλλων που θα τραβήξει υπάρχει 7αρι, μπορεί να το παίξει, αλλά ισχύει σαν να είναι το πρώτο 7άρι (ο επόμενος παίκτης θα τραβήξει 2 φύλλα).')
    elif given_card[0]=='8':
        print('Αν ένας παίκτης ρίξει 8, πρέπει να ξαναπαίξει. Αν δεν έχει κατάλληλο φύλλο, πρέπει να τραβήξει από την τράπουλα και αν δεν βρει κατάλληλο φύλλο να πάει πάσο. Ένας παίκτης μπορεί να παίξει στη σειρά όσα 8άρια έχει στη διάθεσή του. Ο παίκτης δεν μπορεί να βγει με 8.')
    else:
        print('Αν ένας παίκτης ρίξει 9, τότε ο επόμενος παίκτης χάνει τη σειρά του (παίζει δηλαδή ο μεθεπόμενος παίκτης από αυτόν που έριξε το 9). Στην περίπτωση 2 παικτών ο ίδιος παίκτης παίζει δεύτερη φορά όπως γίνεται και με το 8.')

def card_effect(given_card,list_player_names,closed_deck,open_deck,player_cards):
    """ does the aprropriate effect the special card has on the game"""
    global open_card,player,player_index,sequential_7cards
    if given_card[0]=='A':
        if player=='Υπολογιστής':
            series=['κούπα','σπαθί','καρό','μπαστούνι']
            card_series=random.choice(series)
        else:
            card_series=input('Δώσε την επιθημητή σειρά του ανοικτού φύλλου(κούπα-♥/σπαθί-♣/καρό-♦/μπαστούνι-♠):')
            while card_series!='κούπα' and card_series!='κουπα'and card_series!='σπαθί' and  card_series!='σπαθι' and  card_series!='καρό' and  card_series!='καρο' and  card_series!='μπαστούνι' and  card_series!='μπαστουνι':
                card_series=input('Λάθος είσοδος.Εισάγετε ξανά:')
            if card_series=='κούπα' or card_series=='κουπα':
                card_series='♥'
            elif card_series=='σπαθί' or card_series=='σπαθι':
                card_series='♣'
            elif card_series=='καρό' or card_series=='καρο':
                card_series='♦'
            else:
                card_series='♠'
        open_card=('A',card_series,11)
        player=next_player(player,list_player_names,player_index,open_card,given_card)
        player_index=list_player_names.index(player)
    elif given_card[0]=='7':
        #make the next player draw 2 cards
        if matches(given_card,open_card)==True:
            if open_card[0]=='7' and given_card[0]=='7' and len(open_deck)>1:
                sequential_7cards+=1
            else:
                sequential_7cards=0
            open_card=('7',given_card[1],7)
            player=next_player(player,list_player_names,player_index,open_card,given_card)
            player_index=list_player_names.index(player)
            if player_has_7(player_cards)==False:
                for i in range(sequential_7cards*2 + 2):
                    draw_card(closed_deck,player_cards[player_index],open_deck,list_player_names[player_index],list_player_names)
                sequential_7cards=0
        else:
            print('Η κάρτα σου δεν ταιριάζει με την ανοικτή κάρτα :(')
            print('*Πάσο*')
            draw_card(closed_deck,player_cards[player_index],open_deck,list_player_names[player_index],list_player_names)
            player=next_player(player,list_player_names,player_index,open_card,given_card)
            player_index=list_player_names.index(player)
    elif given_card[0]=='8':
        #the player plays again
        if matches(given_card,open_card)==True:
            if len(p_cards)==1:
                draw_card(closed_deck,p_cards,open_deck,list_player_names[player_index],list_player_names)
            open_card=given_card
        else:
            print('Η κάρτα σου δεν ταιριάζει με την ανοικτή κάρτα :(')
            print('*Πάσο*')
            draw_card(closed_deck,p_cards,open_deck,list_player_names[player_index],list_player_names)
            player=next_player(player,list_player_names,player_index,open_card,given_card)
            player_index=list_player_names.index(player)
    else:
        # the player after the next player plays
        if matches(given_card,open_card)==True:
            open_card=given_card
            player=next_player(player,list_player_names,player_index,open_card,given_card)
            player_index=list_player_names.index(player)
            print('*Ο χρήστης',player,'χάνει την σειρά του*')
            player=next_player(player,list_player_names,player_index,open_card,given_card)
            player_index=list_player_names.index(player)
        else:
            print('Η κάρτα σου δεν ταιριάζει με την ανοικτή κάρτα :(')
            print('*Πάσο*')
            draw_card(closed_deck,p_cards,open_deck,list_player_names[player_index],list_player_names)
            player=next_player(player,list_player_names,player_index,open_card,given_card)
            player_index=list_player_names.index(player)

def print_cards():
    """ prints the cards of the player """
    for i in range(len(p_cards)):
        print(i,':',p_cards[i])

def next_player(player,list_player_names,player_index,open_card,given_card):
    """ returns the next player
    >>> list_player_names=['Mark','John','Harry','Henry']
    >>> player_index=0
    >>> player='Mark'
    >>> next_player(player,list_player_names,player_index,('A', '♥', 11))
    'John'
    >>> player_index=3
    >>> player='Henry'
    >>> next_player(player,list_player_names,player_index,('3', '♥', 3))
    'Mark'
    >>> player_index=1
    >>> next_player(player,list_player_names,player_index,('8', '♥', 8))
    'John'
    """
    if open_card[0]=='8' and matches(given_card,open_card)==True:
        return list_player_names[player_index]
    else:
        if player==list_player_names[-1]:
            return list_player_names[0]
        else:
            return list_player_names[player_index + 1]

def find_score(list_player_names,player_cards,players_number):
    """creates dictionary with the key being the player name and the value being the score

    >>> players_number=4
    >>> list_player_names=['Mark','John','Harry','Henry']
    >>> p1_cards=[('A', '♥', 11),('K', '♣', 10), ('5', '♥', 5), ('7', '♣', 7), ('8', '♣', 8), ('5', '♦', 5),('J', '♠', 10)]
    >>> p2_cards=[('A', '♥', 11),('4', '♦', 4), ('2', '♠', 2), ('3', '♣', 3), ('9', '♣', 9), ('5', '♦', 5),('A', '♠', 11)]
    >>> p3_cards=[('Q', '♠', 11),('K', '♣', 10), ('2', '♠', 2), ('10', '♣', 10), ('6', '♣', 6), ('4', '♦', 4),('K', '♠', 10)]
    >>> p4_cards=[]
    >>> player_cards=[p1_cards,p2_cards,p3_cards,p4_cards]
    >>> find_score(list_player_names,player_cards,players_number)
    {'Mark': 56, 'John': 45, 'Harry': 53, 'Henry': 0}
    """
    score={}
    for i in range(players_number):
        if len(player_cards[i])==0:
            score[list_player_names[i]]=0
        else:
            s=0
            for j in range(len(player_cards[i])):
                s+=player_cards[i][j][2]
            score[list_player_names[i]]=s
    return score

def print_score(score):
    """prints the score and the name of each player"""
    print('Πίνακας βαθμολογιών:')
    for key,value in score.items():
        print(key,':',value)

def first_cards(closed_deck):
    """returns 7 random cards for a player"""
    cards=random.sample(closed_deck,7)
    #Checks the cards given dont exceed 50pt
    score=0
    for i in range(7):
        score+=cards[i][2]
    while score>50:
        cards=random.sample(closed_deck,7)
        score=0
        for i in range(7):
            score+=cards[i][2]
    return cards

def new_closed_deck(player_cards,k,closed_deck):
    for i in range(7):
        closed_deck.remove(player_cards[k][i])
    return closed_deck

def player_has_7(player_cards):
    """checks if the player has a 7 card"""
    extra_cards=player_cards[player_index]
    extra_cards=extra_cards[-sequential_7cards:]
    for i in range(len(extra_cards)):
        if extra_cards[i][0]=='7':
            return True
    return False