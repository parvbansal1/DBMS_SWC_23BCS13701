select sent.date,
    count(accept.action) / count(sent.action)::
    decimal  as 
    percentage_acceptance
from fb_friend_requests sent
left join fb_friend_requests accept
on sent.user_id_sender = accept.user_id_sender
and sent.user_id_receiver = accept.user_id_receiver
and accept.action = 'accepted'
where sent.action = 'sent'
group by sent.date;
